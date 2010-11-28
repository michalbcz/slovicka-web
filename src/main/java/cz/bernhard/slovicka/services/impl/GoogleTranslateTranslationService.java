package cz.bernhard.slovicka.services.impl;

import java.util.List;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.GetMethod;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;

import cz.bernhard.slovicka.domains.TranslationResult;
import cz.bernhard.slovicka.domains.Word;
import cz.bernhard.slovicka.services.AbstractTranslationService;

/**
 * Using Google Translate API to retrieve word definition.
 * Problem is that google translate api is primarily for text translation not 
 * for dictionary usage so it returns only one possible translation of 
 * the particular word.
 * 
 * @author Michal Bernhard <michal@bernhard.cz>
 *
 */
@Service
public class GoogleTranslateTranslationService extends AbstractTranslationService {

	private final static Logger log = LoggerFactory.getLogger(GoogleTranslateTranslationService.class);
	
	@Override
	public TranslationResult translate(String word, String from, String to) {
				
		log.debug(
				"Request for translation of {} from language {} to {}",
				new String[] {word, from, to});
		
		String langPair = from + "|" + to;
	
		
		GetMethod getMethod = new GetMethod();
//		getMethod.setRequestHeader(new Header("Referer", "http://www.somesite.com"));
		getMethod.setQueryString(
					new NameValuePair[] { 
							new NameValuePair("v", "1.0"),
							new NameValuePair("q", word),
							new NameValuePair("langpair", langPair)});
		getMethod.setPath("/ajax/services/language/translate");
		try {
			HttpClient client = new HttpClient();	
			client.startSession("ajax.googleapis.com", 80);
			client.executeMethod(getMethod);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
		String response = getMethod.getResponseBodyAsString();
		log.debug("Response of API: {}", response);

		Word translatedWord = null;
		try {
			JSONObject jsonObject = new JSONObject(response);
			JSONObject responseObject = jsonObject.getJSONObject("responseData");
			String translatedText = responseObject.getString("translatedText");
			translatedWord = new Word(translatedText);
		} catch (JSONException e) {
			throw new RuntimeException(e);
		}
		
		List<Word> words = Lists.newArrayList();
		words.add(translatedWord);
		
		return new TranslationResult(words);
		
	}

}
