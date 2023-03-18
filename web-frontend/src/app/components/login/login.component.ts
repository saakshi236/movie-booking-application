import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { User } from 'src/app/class/user';
import { RegistrationService } from 'src/app/services/registration.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  message: String;

  user = new User();

  constructor(private service: RegistrationService, private route: Router) { }

  ngOnInit(): void {
  }

  submitLoginCred() {
    this.service.logicUserFromRest(this.user).subscribe(
      data => {
        console.log("Response Received!");
        alert("Login Succesful!");
        this.route.navigate(["/home"]);
      },
      error => {
        console.log("Error occured!"),
          this.message = "Please enter valid credentials"
      },
    )
  }
}
