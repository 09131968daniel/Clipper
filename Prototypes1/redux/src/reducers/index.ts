import State from "react-redux";
import { combineReducers } from "redux";
import { clickerReducer } from "./clickerReducer";

export interface IClickerState {
    numOfClicks: number;
}

export interface IState {
    ClickerState: IClickerState;
}

export const state = combineReducers<IState>({
    ClickerState: clickerReducer,
});
