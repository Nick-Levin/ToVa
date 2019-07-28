package org.pojo;

import java.util.Objects;
import java.util.UUID;

import org.util.Encryptor;

import com.alibaba.fastjson.annotation.JSONCreator;
import com.alibaba.fastjson.annotation.JSONPOJOBuilder;
import com.alibaba.fastjson.annotation.JSONType;

public class User {

	private final UUID id;
	private final String username;
	private final String password;
	private final String email;
	private final String role;

	public User(String id, String username, String password, String email, String role) {
		this.id = UUID.fromString(id);
		this.username = username;
		this.password = password;
		this.email = email;
		this.role = role;
	}
	
	@JSONCreator
	public User(String username, String password, String email, String role) {
		this.id = UUID.randomUUID();
		this.username = username;
		this.password = Encryptor.encrypt(password);
		this.email = email;
		this.role = role;
	}

	public UUID getId() {
		return id;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public String getEmail() {
		return email;
	}

	public String getRole() {
		return role;
	}

	@Override
	public int hashCode() {
		return Objects.hash(email, id, password, role, username);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof User)) {
			return false;
		}
		User other = (User) obj;
		return Objects.equals(email, other.email) && Objects.equals(id, other.id)
				&& Objects.equals(password, other.password) && Objects.equals(role, other.role)
				&& Objects.equals(username, other.username);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("User [id=");
		builder.append(id);
		builder.append(", username=");
		builder.append(username);
		builder.append(", password=");
		builder.append(password);
		builder.append(", email=");
		builder.append(email);
		builder.append(", role=");
		builder.append(role);
		builder.append("]");
		return builder.toString();
	}

}
