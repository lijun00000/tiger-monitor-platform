import { Component, OnInit } from '@angular/core';
interface ItemData {
  name: string;
  age: number;
  address: string;
}

@Component({
  selector: 'app-zone-table',
  templateUrl: './zone-table.component.html',
  styleUrls: ['./zone-table.component.css']
})
export class ZoneTableComponent implements OnInit {

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
