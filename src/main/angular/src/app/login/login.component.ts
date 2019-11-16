import {Component, OnInit} from '@angular/core';
import {NzMessageService} from "ng-zorro-antd";
import {Router} from "@angular/router";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  private userAccount: string;
  private password: string;

  constructor(private message: NzMessageService, private router: Router) {
  }

  ngOnInit() {
  }

  login() {
    if (this.userAccount === 'admin' && this.password === 'admin') {
      sessionStorage.setItem('loginStatus', 'true');
      this.router.navigateByUrl('/platform-management');
    } else {
      this.message.create('error', '登录失败');
      this.userAccount = '';
      this.password = '';
    }
  }
}
