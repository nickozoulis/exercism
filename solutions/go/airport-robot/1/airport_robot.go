package airportrobot

import "fmt"

type Greeter interface {
	LanguageName() string
	Greet(visitorName string) string
}

type German struct{}

func (g German) LanguageName() string {
	return "German"
}

func (g German) Greet(visitorName string) string {
	return fmt.Sprintf("Hallo %s", visitorName)
}

type Italian struct{}

func (g Italian) LanguageName() string {
	return "Italian"
}

func (g Italian) Greet(visitorName string) string {
	return fmt.Sprintf("Ciao %s", visitorName)
}

type Portuguese struct{}

func (g Portuguese) LanguageName() string {
	return "Portuguese"
}

func (g Portuguese) Greet(visitorName string) string {
	return fmt.Sprintf("Olá %s", visitorName)
}

func SayHello(visitorName string, g Greeter) string {
	return fmt.Sprintf("I can speak %s: %s!", g.LanguageName(), g.Greet(visitorName))
}
