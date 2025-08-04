defmodule RotationalCipher do
  @lower_a 97
  @lower_z 122
  @lowercase @lower_a..@lower_z
  @upper_a 65
  @upper_z 90
  @uppercase @upper_a..@upper_z

  @doc """
  Given a plaintext and amount to shift by, return a rotated string.

  Example:
  iex> RotationalCipher.rotate("Attack at dawn", 13)
  "Nggnpx ng qnja"
  """
  @spec rotate(text :: String.t(), shift :: integer) :: String.t()
  def rotate(text, 26), do: text
  def rotate(text, shift) do
    text <> <<0>>
    |> transform(shift)
  end

  defp transform(<<0>>, _shift, acc), do: acc
  defp transform(<<32, tail :: binary>>, shift, acc) do
    transform(tail, shift, acc <> <<32>>)
  end
  defp transform(<<head, tail :: binary>>, shift, acc \\ <<>>) do
    sum = head + shift

    cond do
      head in @uppercase and sum in @uppercase or head in @lowercase and sum in @lowercase ->
        transform(tail, shift, acc <> <<sum>>)
      head in @uppercase and sum > @upper_z ->
        wrap(sum, @upper_z, @upper_a)
        |> (&(transform(tail, shift, acc <> <<&1>>))).()
      head in @lowercase and sum > @lower_z ->
        wrap(sum, @lower_z, @lower_a)
        |> (&(transform(tail, shift, acc <> <<&1>>))).()
      true ->
        transform(tail, shift, acc <> <<head>>)
    end
  end

  defp wrap(num, upper_bound, lower_bound), do: num - upper_bound + lower_bound - 1

end