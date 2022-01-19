import { Injectable } from "@angular/core";
import { Actions, createEffect, ofType } from "@ngrx/effects";
import { catchError, map, switchMap, takeUntil } from "rxjs";
import { UserService } from "../user.service";
import { incrementCounter, loadUserCancel, loadUserFailure, loadUsers, loadUserSuccess, setValue } from "./actions";

@Injectable()
export class GlobalEffects {

    increment = createEffect(() => this.ations$.pipe(
        ofType(setValue),
        map(action => {
            console.log(action);
            return incrementCounter();
        })
    ))

    loadUsers = createEffect(() => this.ations$.pipe(
        ofType(loadUsers),
        switchMap(
            () => this.userService.loadUsers().pipe(
                takeUntil(this.ations$.pipe(ofType(loadUserCancel))),
                map(users => loadUserSuccess({ users })),
                catchError(error => [loadUserFailure({ error })])
            )
        )
    ))

    constructor(private ations$: Actions,
        private userService: UserService) { }
}