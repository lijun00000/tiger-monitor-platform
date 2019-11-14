import {AfterViewInit, Component, OnInit} from '@angular/core';
@Component({
  selector: 'app-system-management',
  templateUrl: './system-management.component.html',
  styleUrls: ['./system-management.component.css']
})
export class SystemManagementComponent implements OnInit,AfterViewInit{
  ngAfterViewInit(): void {
    let x = this;
    setInterval(function () {
      x.sum_up();
    },1000)
  }

  private sum:number = 103220;

  constructor() {

  }

  sum_up(){
    this.sum = this.sum+1;
  }

  ngOnInit() {

  }

}


