import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private httpClient: HttpClient) { }

  loadUsers() {
    return this.httpClient.get<any[]>('https://jsonplaceholder.typicode.com/users')
  }
}
