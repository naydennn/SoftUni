import { Component } from '@angular/core';
import { Actions, ofType } from '@ngrx/effects';
import { Store } from '@ngrx/store';
import { mapTo, merge, of } from 'rxjs';
import { clearAppState, incrementCounter, loadUserFailure, loadUsers, loadUserSuccess, setValue } from './+store/actions';
import { selectGlobalCounter, selectGlobalUsers, selectGlobalValue } from './+store/selectors';



@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

  title = 'ngrx-demo';

  counter$ = this.store.select(selectGlobalCounter);
  value$ = this.store.select(selectGlobalValue);
  users$ = this.store.select(selectGlobalUsers);

  isLoadingUsers$ = merge(
      this.actions$.pipe(ofType(loadUsers), mapTo(true)),
      this.actions$.pipe(ofType(loadUserSuccess), mapTo(false)),
      this.actions$.pipe(ofType(loadUserFailure), mapTo(false)),
      of(false)
  )

  constructor(private store: Store<any>,
    private actions$: Actions) {}

  incrementCounter(): void {
    this.store.dispatch(incrementCounter())
  }

  setValue(valueInput: HTMLInputElement) {
    this.store.dispatch(setValue({ value: valueInput.value}));
    valueInput.value = '';
  }

  loadUsers() {
    this.store.dispatch(loadUsers())
  };

  resetState() {
    this.store.dispatch(clearAppState())
  }
}
