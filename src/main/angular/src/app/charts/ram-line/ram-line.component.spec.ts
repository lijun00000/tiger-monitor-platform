import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RamLineComponent } from './ram-line.component';

describe('RamLineComponent', () => {
  let component: RamLineComponent;
  let fixture: ComponentFixture<RamLineComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RamLineComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RamLineComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
