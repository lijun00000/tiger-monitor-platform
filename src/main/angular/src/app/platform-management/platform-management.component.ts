import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-platform-management',
  templateUrl: './platform-management.component.html',
  styleUrls: ['./platform-management.component.css']
})
export class PlatformManagementComponent implements OnInit {

  servers = [
    {server:"node-70",selected:false},
    {server:"node-65",selected:false},
    {server:"node-64",selected:false},
    {server:"node-63",selected:false},
    {server:"node-62",selected:true},
    {server:"node-61",selected:false}
  ];
  constructor() { }

  ngOnInit() {
  }

}
