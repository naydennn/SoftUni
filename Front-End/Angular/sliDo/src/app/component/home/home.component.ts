import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { EventService } from 'src/app/core/service/event.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  eventForm!: FormGroup;

  constructor(private formBuilder: FormBuilder,
    private eventService: EventService) { }

  ngOnInit(): void {
    this.eventForm = this.formBuilder.group({
      code: [null, [Validators.required]]
    });
  }

  displayLiveEvent() {
    const code = this.eventForm.value.code;

    // this.eventService.fetchEventByCode(code);
  }

}
