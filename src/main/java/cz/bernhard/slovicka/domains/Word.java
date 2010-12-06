package cz.bernhard.slovicka.domains;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity(name="words")
@Table(name="words")
public class Word {
	
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private Long id;
	
	@Column(name = "word")
	private String word;
	
	@Column(name = "count_of_findings")
	private Long countOfFindings; /* indicates how many times user looking for this word */
	
	@OneToOne(
			optional=false,
			fetch=FetchType.LAZY
	)  
	private User user;

	public Word() { /* default constructor to conform JavaBean spec */ }
	
	public Word(String word) {
		this.word = word;		
	}

	public Long getId() {
		return id;
	}

	public Word setId(Long id) {
		this.id = id;
		return this;
	}

	public Word setWord(String word) {
		this.word = word;
		return this;
	}
	
	public String getWord() {
		return word;
	}
		

	public Long getCountOfFindings() {
		return countOfFindings;
	}

	public Word setCountOfFindings(Long countOfFindings) {
		this.countOfFindings = countOfFindings;
		return this;
	}

	public User getUser() {
		return user;
	}

	public Word setUser(User user) {
		this.user = user;
		return this;
	}

	@Override
	public String toString() {
		return "word = " + word;
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((word == null) ? 0 : word.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Word other = (Word) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (word == null) {
			if (other.word != null)
				return false;
		} else if (!word.equals(other.word))
			return false;
		return true;
	}
	
}
