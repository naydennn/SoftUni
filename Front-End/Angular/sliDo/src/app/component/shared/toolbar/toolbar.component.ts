import { Component, EventEmitter, OnInit, Output } from '@angular/core';

@Component({
  selector: 'app-toolbar',
  templateUrl: './toolbar.component.html',
  styleUrls: ['./toolbar.component.css']
})
export class ToolbarComponent implements OnInit {

  @Output() onToggleSidenav = new EventEmitter<void>();

  constructor() { }

  ngOnInit(): void {
  }

  toggleSidenav() {
    this.onToggleSidenav.emit();
  }

}
