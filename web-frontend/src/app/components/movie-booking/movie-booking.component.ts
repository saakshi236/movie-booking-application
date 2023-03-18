import { ConditionalExpr } from '@angular/compiler';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { forkJoin } from 'rxjs';
import { Booking } from 'src/app/class/booking';
import { Movie } from 'src/app/class/movie';
import { MovieService } from 'src/app/services/movie.service';

@Component({
  selector: 'app-movie-booking',
  templateUrl: './movie-booking.component.html',
  styleUrls: ['./movie-booking.component.css']
})
export class MovieBookingComponent implements OnInit {
  booking = new Booking();
  movie: Movie = new Movie();
  id: number;
  shows: any[];
  screenTypes: any[];
  theatre: any[];
  ticketCount: number = 1;
  totalAmount: number = 0;
  ticketType: number;

  constructor(private service: MovieService, private route: ActivatedRoute,
    private router: Router) { }

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];
    this.service.getMoviesById(this.id).subscribe(
      data => {
        console.log(data);
        this.movie = data;
      },
      error => this.router.navigate(["/error"]),
    )

    this.service.getShowList().subscribe(
      data => {
        console.log(data);
        this.shows = data;
      },
      error => this.router.navigate(["/error"]),
    )

    this.service.getTheatreList().subscribe(
      data => {
        console.log(data);
        this.theatre = data;
      },
      error => this.router.navigate(["/error"]),
    )

    this.service.getScreenType().subscribe(
      data => {
        console.log(data);
        this.screenTypes = data;
      },
      error => this.router.navigate(["/error"]),
    )
  }

  selectTheatre(val: any) {
    this.service.loadScreenListByTheatre(val).subscribe()
  }

  change1(event) {
    this.ticketType = event.target.value;
    this.totalAmount = event.target.value * this.ticketCount;
  }

  change(event) {
    this.totalAmount = event.target.value * this.ticketType;
  }

  submitBookingVal() {
    this.booking.title = this.movie.title;
    console.log(this.booking.title);
    this.booking.ticketPrice = this.totalAmount;
    this.service.submitBookingVal(this.booking).subscribe(
      data => {
        console.log(this.booking.ticketPrice);
        console.log("Response Received!");
        this.router.navigate(["/bookings"]);
      },
      error => this.router.navigate(["/error"]),
    )
  }

}
