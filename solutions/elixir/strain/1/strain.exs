defmodule Strain do
  @doc """
  Given a `list` of items and a function `fun`, return the list of items where
  `fun` returns true.

  Do not use `Enum.filter`.
  """
  @spec keep(list :: list(any), fun :: ((any) -> boolean)) :: list(any)
  def keep(list, fun) do
    operate(list, fun)
    |> Enum.reverse
  end

  defp operate(list, fun, acc \\ [])
  defp operate([], _fun, acc), do: acc
  defp operate([head | tail], fun, acc) do
    case fun.(head) do
      true -> [head | acc]
      false -> acc
    end
    |> (&(operate(tail, fun, &1))).()
  end

  @doc """
  Given a `list` of items and a function `fun`, return the list of items where
  `fun` returns false.

  Do not use `Enum.reject`.
  """
  @spec discard(list :: list(any), fun :: ((any) -> boolean)) :: list(any)
  def discard(list, fun) do
    fn x -> !fun.(x) end
    |> (&(operate(list, &1))).()
    |> Enum.reverse
  end
end