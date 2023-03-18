import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { User } from 'src/app/class/user';
import { RegistrationService } from 'src/app/services/registration.service';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit {
  user: User;
  message: String;

  constructor(private service: RegistrationService, private route: Router) { }

  ngOnInit(): void {
  }

  change(event) {
    if (this.user.password != event.target.value) {
      this.message = "Re-entered password does not match"
    }
  }

  registerUser() {
    if (this.user.password)
      this.user.password
    this.service.registerUser(this.user).subscribe(
      data => {
        console.log("Response Received!");
        alert("Login Succesful!");
        this.route.navigate(["/login"]);
      },
      error => {
        console.log("Error occured!"),
          this.message = "Please enter valid credentials"
      },
    )
  }
}
