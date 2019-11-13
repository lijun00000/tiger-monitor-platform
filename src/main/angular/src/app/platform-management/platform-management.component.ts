import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-platform-management',
  templateUrl: './platform-management.component.html',
  styleUrls: ['./platform-management.component.css']
})
export class PlatformManagementComponent implements OnInit {

  servers = [
    {server:"node-5",selected:false},
    {server:"node-4",selected:false},
    {server:"node-3",selected:false},
    {server:"node-2",selected:true},
    {server:"node-1",selected:false}
  ];
  constructor() { }

  ngOnInit() {
  }

}
