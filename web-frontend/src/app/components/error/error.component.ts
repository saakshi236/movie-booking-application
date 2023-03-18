import { Component, OnInit } from '@angular/core';
import { ErrorService } from 'src/app/services/error.service';

@Component({
  selector: 'app-error',
  templateUrl: './error.component.html',
  styleUrls: ['./error.component.css']
})
export class ErrorComponent implements OnInit {

  message: String;

  constructor(private service: ErrorService) { }

  ngOnInit(): void {
  }

}
