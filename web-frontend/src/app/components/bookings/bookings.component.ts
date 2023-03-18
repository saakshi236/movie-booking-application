import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { MovieService } from 'src/app/services/movie.service';

@Component({
  selector: 'app-bookings',
  templateUrl: './bookings.component.html',
  styleUrls: ['./bookings.component.css']
})
export class BookingsComponent implements OnInit {
  bookingList: any[];
  constructor(private service: MovieService, private router: Router) { }

  ngOnInit(): void {
    this.service.getListOfBookings().subscribe(data => {
      this.bookingList = data;
    },
    )
  }

  deleteBooking(id: number) {
    this.service.deleteBooking(id).subscribe(data => {
      console.log(data);
    },
      error => this.router.navigate(["/error"])
    )
    alert('Record Deleted');

    this.service.getListOfBookings().subscribe(data => {
      this.bookingList = data;
    },
      error => this.router.navigate(["/error"])
    )
    this.router.navigate(['bookings']);
  }

  updateBooking(id: number) {
    this.router.navigate(['updateMovie', id]);
  }
}
