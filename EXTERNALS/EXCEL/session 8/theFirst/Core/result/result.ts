export type Result<T, E> = Ok<T> | Err<E>;

interface Ok<T> {
  kind: 'Ok';
  value: T;
  isOk(): boolean;
  isErr(): boolean;
  unwrap(): T;
  unwrapErr(): never;
}

interface Err<E> {
  kind: 'Err';
  error: E;
  isOk(): boolean;
  isErr(): boolean;
  unwrap(): never;
  unwrapErr(): E;
}

export function Ok<T>(value: T): Ok<T> {
  return {
    kind: 'Ok',
    value,
    isOk: () => true,
    isErr: () => false,
    unwrap: () => value,
    unwrapErr: () => { throw new Error('Cannot unwrapErr an Ok value'); },
  };
}

export function Err<E>(error: E): Err<E> {
  return {
    kind: 'Err',
    error,
    isOk: () => false,
    isErr: () => true,
    unwrap: () => { throw new Error('Cannot unwrap an Err value'); },
    unwrapErr: () => error,
  };
}