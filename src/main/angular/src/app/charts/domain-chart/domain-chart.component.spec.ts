import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DomainChartComponent } from './domain-chart.component';

describe('DomainChartComponent', () => {
  let component: DomainChartComponent;
  let fixture: ComponentFixture<DomainChartComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DomainChartComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DomainChartComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
