import { createReducer, on } from "@ngrx/store";
import { clearGLobalState, incrementCounter, loadUserSuccess, setValue } from "./actions";

export interface IGlobalState {
    readonly counter: number;
    readonly value: any;
    readonly users: any[] | null;
}

const initialState: IGlobalState = {
    counter: 0,
    value: null,
    users: null,
}

export const globalReducer = createReducer(
    initialState,
    on(incrementCounter, (state) => ({ ...state, counter: state.counter + 1 })),
    on(setValue, (state, { value }) => ({ ...state, value: value })),
    on(loadUserSuccess, (state, { users }) => ({ ...state, users })),
    on(clearGLobalState, () => initialState)
);