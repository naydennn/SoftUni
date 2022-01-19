import { createAction, props } from '@ngrx/store';

const namescapce = '[GLOBAL]';

export const incrementCounter = createAction(
    `${namescapce} increment counter`
);

export const setValue = createAction(
    `${namescapce} setValue`,
    props<{ value: string; }>()
);

export const loadUsers = createAction(
    `${namescapce} loadUsers`
);

export const loadUserSuccess = createAction(
    `${namescapce} loadUsersSuccess`,
    props<{ users: any[] }>()
);

export const loadUserFailure = createAction(
    `${namescapce} loadUsersFailure`,
    props<{ error: Error }>()
);

export const loadUserCancel = createAction(
    `${namescapce} loadUsersCancel`
);

export const clearGLobalState = createAction(
    `${namescapce} clear state`
);

export const clearAppState = createAction(
    `${namescapce} clear app state`
);