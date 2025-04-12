package com.springboot.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class MediumRiddle  {
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
	    private String question;
	    private String answer;
	    public MediumRiddle(Long id, String question, String answer, int level) {
			super();
			this.id = id;
			this.question = question;
			this.answer = answer;
			this.level = level;
		}
		public MediumRiddle() {
			super();
			// TODO Auto-generated constructor stub
		}
		
	    private int level;
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getQuestion() {
			return question;
		}
		public void setQuestion(String question) {
			this.question = question;
		}
		public String getAnswer() {
			return answer;
		}
		public void setAnswer(String answer) {
			this.answer = answer;
		}
		public int getLevel() {
			return level;
		}
		public void setLevel(int level) {
			this.level = level;
		}
		@Override
		public String toString() {
			return "MediumRiddle [id=" + id + ", question=" + question + ", answer=" + answer + ", level=" + level
					+ "]";
		}
}
