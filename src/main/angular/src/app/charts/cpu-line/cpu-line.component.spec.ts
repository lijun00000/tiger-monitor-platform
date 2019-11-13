import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CpuLineComponent } from './cpu-line.component';

describe('CpuLineComponent', () => {
  let component: CpuLineComponent;
  let fixture: ComponentFixture<CpuLineComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CpuLineComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CpuLineComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
