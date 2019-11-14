import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RapidTableComponent } from './rapid-table.component';

describe('RapidTableComponent', () => {
  let component: RapidTableComponent;
  let fixture: ComponentFixture<RapidTableComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RapidTableComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RapidTableComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
