import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-event-question',
  templateUrl: './event-question.component.html',
  styleUrls: ['./event-question.component.css']
})
export class EventQuestionComponent implements OnInit {

  date = new Date();

  constructor() { }

  ngOnInit(): void {
  }

}
