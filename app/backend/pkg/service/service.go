package service

import (
	"github.com/AndreyMAI-github/HMA_2021/tree/main/app/todo-app"
	"github.com/AndreyMAI-github/HMA_2021/tree/main/app/todo-app/pkg/repository"
)

type Authorization interface {
	CreateUser(user todo.User) (int, error)
	GenerateToken(username, password string) (string, error)
}

type Service struct {
	Authorization
}

func NewService(repos *repository.Repository) *Service {
	return &Service{
		Authorization: NewAuthService(repos.Authorization),
	}
}
