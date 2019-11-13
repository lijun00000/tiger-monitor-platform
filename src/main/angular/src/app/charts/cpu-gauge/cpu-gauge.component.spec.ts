import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CpuGaugeComponent } from './cpu-gauge.component';

describe('CpuGaugeComponent', () => {
  let component: CpuGaugeComponent;
  let fixture: ComponentFixture<CpuGaugeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CpuGaugeComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CpuGaugeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
