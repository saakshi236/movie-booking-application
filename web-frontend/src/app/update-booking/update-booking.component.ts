import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Booking } from '../class/booking';
import { Movie } from '../class/movie';
import { MovieService } from '../services/movie.service';

@Component({
  selector: 'app-update-booking',
  templateUrl: './update-booking.component.html',
  styleUrls: ['./update-booking.component.css']
})
export class UpdateBookingComponent implements OnInit {
  booking = new Booking();
  movie: Movie = new Movie();
  id: number;
  shows: any[];
  screenTypes: any[];
  theatre: any[];
  ticketCount: number = 1;
  totalAmount: number = 0;
  ticketType: number;
  message: String;

  constructor(private service: MovieService, private route: ActivatedRoute,
    private router: Router) {
    this.message = 'Previous';
  }

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];
    console.log(this.id);
    this.service.updateBooking(this.id, this.booking).subscribe(
      data => {
        console.log(data);
        this.booking = data
      },
      error => this.router.navigate(["/error"])
    )

    this.service.getShowList().subscribe(
      data => {
        console.log(data);
        this.shows = data;
      },
      error => this.router.navigate(["/error"])
    )

    this.service.getTheatreList().subscribe(
      data => {
        console.log(data);
        this.theatre = data;
      },
      error => this.router.navigate(["/error"])
    )

    this.service.getScreenType().subscribe(
      data => {
        console.log(data);
        this.screenTypes = data;
      },
      error => this.router.navigate(["/error"])
    )
  }

  datechange(event) {
    this.message = "Current";
  }

  change1(event) {
    this.ticketType = event.target.value;
    this.totalAmount = event.target.value * this.ticketCount;
  }

  change(event) {
    this.totalAmount = event.target.value * this.ticketType;
  }

  submitBookingVal() {
    this.booking.title = this.booking.title;
    console.log(this.booking.title);
    if (this.totalAmount == 0)
      this.booking.ticketPrice = this.booking.ticketPrice;
    else
      this.booking.ticketPrice = this.totalAmount;
    this.service.submitBookingVal(this.booking).subscribe(
      data => {
        console.log(this.booking.ticketPrice);
        console.log("Response Received!");
        this.router.navigate(["/bookings"]);
      },
      error => this.router.navigate(["/error"])
    )
  }
}
