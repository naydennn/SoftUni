import { createFeatureSelector, createSelector } from "@ngrx/store";
import { IUserState } from ".";

const userModuleSelector = createFeatureSelector<IUserState>('user')


export const selectUserList = createSelector(
    userModuleSelector,
    state => state.list
);

export const selectUserDetail = createSelector(
    userModuleSelector,
    state => state.detail
);

export const selectUserListUsers = createSelector(
    selectUserList,
    state => state.users
);

export const selectUserDetailUser = createSelector(
    selectUserDetail,
    state => state.user
);