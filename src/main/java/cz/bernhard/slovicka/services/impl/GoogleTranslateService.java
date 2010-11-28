package cz.bernhard.slovicka.services.impl;

import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Formatter;
import java.util.List;

import org.apache.commons.httpclient.methods.GetMethod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;

import cz.bernhard.slovicka.domains.TranslationResult;
import cz.bernhard.slovicka.domains.Word;
import cz.bernhard.slovicka.services.AbstractTranslateService;

@Service
public class GoogleTranslateService extends AbstractTranslateService {

	private final static Logger log = LoggerFactory.getLogger(GoogleTranslateService.class);
	
	private final String url = 
		"http://ajax.googleapis.com/ajax/services/language/translate?v=1.0&q=%s&langpair=%s%7%s\"";
	
	@Override
	public TranslationResult translate(String word, String from, String to) {
				
		log.debug(
				"Request for translation of {} from language {} to {}",
				new String[] {word, from, to});
		
		word = urlEncode(word);
		from = urlEncode(from);
		to = urlEncode(to);
		
		Formatter formatter = new Formatter();
		String urlFormatted = formatter.format(url, word, from, to).toString();
		URL googleTranslateUrl;
		try {
			googleTranslateUrl = new URL(urlFormatted);			
		} catch (MalformedURLException e) {
			throw new RuntimeException(e);
		}
		
//		InputStream is = googleTranslateUrl.openStream();
		GetMethod getMethod = new GetMethod(googleTranslateUrl.getPath());
		String response = getMethod.getResponseBodyAsString();
		log.info(response);
		
		List<Word> words = Lists.newArrayList(new Word("prdel"), new Word("zadnice"));
		
		return new TranslationResult(words);
		
	}

	private String urlEncode(String url) {
		try {
			return URLEncoder.encode(url, "ISO-8859-1");
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException(e);
		}
	}

}
