import { Component, OnInit } from '@angular/core';
interface ItemData {
  name: string;
  age: number;
  address: string;
}

@Component({
  selector: 'app-rapid-table',
  templateUrl: './rapid-table.component.html',
  styleUrls: ['./rapid-table.component.css']
})
export class RapidTableComponent implements OnInit {

  constructor() { }

  listOfData: ItemData[] = [];

  ngOnInit(): void {
    for (let i = 0; i < 100; i++) {
      this.listOfData.push({
        name: `Edward King ${i}`,
        age: 32,
        address: `London, Park Lane no. ${i}`
      });
    }
  }

}
