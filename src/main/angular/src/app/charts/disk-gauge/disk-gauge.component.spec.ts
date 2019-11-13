import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DiskGaugeComponent } from './disk-gauge.component';

describe('DiskGaugeComponent', () => {
  let component: DiskGaugeComponent;
  let fixture: ComponentFixture<DiskGaugeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DiskGaugeComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DiskGaugeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
