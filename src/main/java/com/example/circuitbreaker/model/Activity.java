package com.example.circuitbreaker.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/* sample message
    {
  "activity": "Do yoga",
  "availability": 0.9,
  "type": "recreational",
  "participants": 1,
  "price": 0,
  "accessibility": "Minor challenges",
  "duration": "minutes",
  "kidFriendly": true,
  "link": "",
  "key": "4688012"
}
    */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Activity {
    private String activity;
    private String type;
    private String link;
    private String key;
    private Integer participants;
    private Double price;
    private String accessibility;
}
