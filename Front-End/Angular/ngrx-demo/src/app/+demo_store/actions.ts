export function updateCounter() {
    return { type: 'INC' }
}

export function setValue(value: any) {
    return {
        type: 'SET_VALUE',
        payload: value
    };
}