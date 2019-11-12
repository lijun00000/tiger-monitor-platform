import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-platform-management',
  templateUrl: './platform-management.component.html',
  styleUrls: ['./platform-management.component.css']
})
export class PlatformManagementComponent implements OnInit {

  servers = [
    {server:"node-1"},
    {server:"node-2"},
    {server:"node-3"},
    {server:"node-4"},
    {server:"node-5"}
  ];
  constructor() { }

  ngOnInit() {
  }

}
