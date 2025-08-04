defmodule SecretHandshake do
  @doc """
  Determine the actions of a secret handshake based on the binary
  representation of the given `code`.

  If the following bits are set, include the corresponding action in your list
  of commands, in order from lowest to highest.

  1 = wink
  10 = double blink
  100 = close your eyes
  1000 = jump

  10000 = Reverse the order of the operations in the secret handshake
  """
  @mappings ["wink", "double blink", "close your eyes", "jump", "reverse"]

  @spec commands(code :: integer) :: list(String.t())
  def commands(code) when code > 31, do: []
  def commands(code) do
    code
    |> Integer.to_string(2)
    |> String.reverse
    |> String.graphemes
    |> decode
  end

  defp decode(graphemes) do
    signal =
      graphemes
      |> Enum.with_index
      |> Enum.flat_map(fn {char, index}->
      case char do
        "1" -> [sign_at(index)]
        "0" -> []
      end
    end)

    cond do
      List.last(signal) == "reverse" -> Enum.drop(signal, -1) |> Enum.reverse
      true -> signal
    end
  end

  defp sign_at(k), do: Enum.at(@mappings, k)
end