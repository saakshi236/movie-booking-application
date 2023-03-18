import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/internal/Observable';

@Injectable({
  providedIn: 'root'
})
export class ErrorService {

  constructor(private http: HttpClient) { }

  public getErrorHandling(): Observable<any> {
    return this.http.get<any>("http://localhost:8090/error")
  }
}
