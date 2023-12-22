package com.example.demojpa;

import java.io.File;
import java.util.HashMap;
import java.util.Map;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.Poller;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.integration.file.FileReadingMessageSource;
import org.springframework.integration.file.FileWritingMessageHandler;
import org.springframework.integration.file.filters.CompositeFileListFilter;
import org.springframework.integration.file.filters.SimplePatternFileListFilter;

import org.springframework.messaging.MessageHandler;

@Configuration
@EnableIntegration
public class FileIntegration {
	
	@Value("${poll.directory}")
	public String uploadDirectory;

	@Value("${filename.pattern}")
	public String triggerFilenamePattern;

	@Value("${write.directory}")
	public String writeDirectory;
	
	@Bean
	@InboundChannelAdapter(value = "fileInputChannel", poller = @Poller(fixedRate = "${poll.interval}"))
	public FileReadingMessageSource fileReadingMessageSource() {

		CompositeFileListFilter<File> filters = new CompositeFileListFilter<>();
		filters.addFilter(new SimplePatternFileListFilter(triggerFilenamePattern));
		FileReadingMessageSource reader = new FileReadingMessageSource();
		reader.setDirectory(new File(uploadDirectory));
		reader.setFilter(filters);
		return reader;
	}
	
	@Bean
	@ServiceActivator(inputChannel = "fileInputChannel")
	public FileWritingMessageHandler fileWritingMessageHandler() {

		FileWritingMessageHandler writer = new FileWritingMessageHandler(new File(writeDirectory));
		writer.setAutoCreateDirectory(true);
		writer.setExpectReply(false);
		return writer;

	}

}
