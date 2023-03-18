import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { forkJoin } from 'rxjs';
import { Observable } from 'rxjs/internal/Observable';
import { Booking } from '../class/booking';
import { Cinema } from '../class/cinema';
import { Movie } from '../class/movie';
import { Show } from '../class/show';

@Injectable({
  providedIn: 'root'
})
export class MovieService {

  movieUrl: string;
  bookingUrl: string;

  constructor(private http: HttpClient) {
    this.movieUrl = 'http://localhost:8090/bookMovie';
    this.bookingUrl = 'http://localhost:8090/booking';
  }

  public getListOfMovies(): Observable<any> {
    return this.http.get<any>("http://localhost:8090/movies")
  }

  public getMoviesById(id: number): Observable<Movie> {
    return this.http.get<Movie>(`${this.movieUrl}/${id}`);
  }

  public getShowList(): Observable<any> {
    return this.http.get<any>("http://localhost:8090/listShows")
  }

  public submitBookingVal(booking: Booking): Observable<any> {
    console.log(booking);
    return this.http.post<any>("http://localhost:8090/saveBooking", booking)
  }

  public getListOfBookings(): Observable<any> {
    return this.http.get<any>("http://localhost:8090/bookingsList")
  }

  public deleteBooking(id: number): Observable<any> {
    return this.http.delete(`${this.movieUrl}/${id}`)
  }

  public getTheatreList(): Observable<any> {
    return this.http.get<any>("http://localhost:8090/cinemaNameList")
  }

  public getScreenType(): Observable<any> {
    return this.http.get<any>("http://localhost:8090/screenType")
  }

  public loadScreenListByTheatre(cinema: Cinema): Observable<any> {
    return this.http.post<any>("http://localhost:8090/loadScreenList", cinema)
  }

  public updateBooking(id: number, value: any): Observable<any> {
    return this.http.put<any>(`${this.bookingUrl}/${id}`, value)
  }

}
