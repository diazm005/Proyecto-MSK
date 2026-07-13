import { Injectable } from '@angular/core';

@Injectable({ providedIn: 'root' })
export class AuthService {

  getToken(): string | null {
    return localStorage.getItem('token');
  }

  isLoggedIn(): boolean {
    return !!this.getToken();
  }

  logout() {
    localStorage.removeItem('token');
  }
}