package com.homework.contestservices.uniquewordscount.services;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UniqueWordCountImpl {
   private Map<String, Integer> wordsCount = new HashMap<String, Integer>();
   
   public UniqueWordCountImpl(String inputString) {
	   countUniqueWords(inputString);
   }
   public Map<String, Integer> getWordsCount(){
	   return Collections.unmodifiableMap(wordsCount);
   }
   private void countUniqueWords(String inputString) {
	   int currentWordStartIndex =0;
	   int currentWordLength =0;
	   for(int i=0;i<inputString.length();i++) {
		   char character = inputString.charAt(i);
		   if(i == inputString.length()-1) {
			   if(Character.isLetter(character)) {
				   currentWordLength++;
			   }
			   if(currentWordLength > 0) {
				   String currentWord=inputString.substring(currentWordStartIndex, currentWordStartIndex+currentWordLength);
				   addWordToHashMap(currentWord);
			   }
		   }
		   else if(character==' ' || character=='\u2014') {
			   if(currentWordLength > 0) {
				   String currentWord=inputString.substring(currentWordStartIndex, currentWordStartIndex+currentWordLength);
				   addWordToHashMap(currentWord);
				   currentWordLength=0;
			   }
		   }
		   else if(character=='.') {
			   if(i < inputString.length() - 1 && inputString.charAt(i+1) == '.') {
				   if(currentWordLength > 0) {
					   String currentWord=inputString.substring(currentWordStartIndex, currentWordStartIndex+currentWordLength);
					   addWordToHashMap(currentWord);
					   currentWordLength=0;
				   }
			   }
		   }
		   else if(Character.isLetter(character) || character=='\'') {
			   if(currentWordLength==0) {
				   currentWordStartIndex=i;
			   }
			   currentWordLength++;
		   }
		   else if(character =='-') {
			   if(i>0 && Character.isLetter(inputString.charAt(i-1)) && Character.isLetter(inputString.charAt(i+1))) {
				   if(currentWordLength==0) {
					   currentWordStartIndex=i;
				   }
				   currentWordLength++;
			   }
			   else {
				   if(currentWordLength > 0) {
					   String currentWord=inputString.substring(currentWordStartIndex, currentWordStartIndex+currentWordLength);
					   addWordToHashMap(currentWord);
					   currentWordLength=0;
				   }
			   }
		   }
	   }
   }
   private void addWordToHashMap(String word) {
	   if(wordsCount.containsKey(word)) {
		   wordsCount.put(word, wordsCount.get(word)+1);
	   }
	   else if(wordsCount.containsKey(word.toLowerCase())) {
		   int newCount = wordsCount.get(word.toLowerCase())+1;
		   wordsCount.put(word.toLowerCase(),newCount);
	   }
	   else if(wordsCount.containsKey(capitalize(word))) {
		   int newCount = wordsCount.get(capitalize(word))+1;
		   wordsCount.put(word,newCount);
		   wordsCount.remove(capitalize(word));
	   }
   }
   private String capitalize(String word) {
	   return word.substring(0, 1).toUpperCase()+word.substring(1);
   }
}
