import {CanActivate, Router} from "@angular/router";

export class LoginGuard implements CanActivate {

  constructor(private router: Router) {
  }

  canActivate() {
    const item = sessionStorage.getItem('loginStatus');
    if (item) {
      return true;
    } else {
      this.router.navigateByUrl('/login');
    }
  }
}
