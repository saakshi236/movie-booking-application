import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { MovieService } from 'src/app/services/movie.service';

@Component({
  selector: 'app-homepage',
  templateUrl: './homepage.component.html',
  styleUrls: ['./homepage.component.css']
})
export class HomepageComponent implements OnInit {

  movieList: any[];
  constructor(private service: MovieService, private router: Router) {

  }

  ngOnInit(): void {
    this.service.getListOfMovies().subscribe(
      data => {
        console.log(data);
        this.movieList = data;
      },
      error => this.router.navigate(["/error"])
    )
  }


}
