package com.example.demo.domain;



import lombok.Data;

@Data
public class User {
  private int id;
  private String email;
  private String password;
  private String name;
  private String roles;
}