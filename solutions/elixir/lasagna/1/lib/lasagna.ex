defmodule Lasagna do
  # Please define the 'expected_minutes_in_oven/0' function

  @expected_mins_in_oven 40
  @mins_per_layer 2

  def expected_minutes_in_oven do
    @expected_mins_in_oven
  end

  # Please define the 'remaining_minutes_in_oven/1' function
  def remaining_minutes_in_oven(actual_mins_in_oven) do
    expected_minutes_in_oven() - actual_mins_in_oven
  end

  # Please define the 'preparation_time_in_minutes/1' function
  def preparation_time_in_minutes(num_of_layers) do
    num_of_layers * @mins_per_layer
  end


  # Please define the 'total_time_in_minutes/2' function
  def total_time_in_minutes(num_of_layers, actual_mins_in_oven) do
    preparation_time_in_minutes(num_of_layers) + actual_mins_in_oven
  end

  # Please define the 'alarm/0' function
  def alarm do
    "Ding!"
  end
end
