class BinaryTree:
    def __init__(self, data=None):
        self.data = data
        self.left = None
        self.right = None

    @property
    def data(self):
        return self.__data

    @data.setter
    def data(self, data):
        self.__data = data

    def add_rightchild(self, node):
        if node is None:
            self.right = node
        elif self.data is None or node.data is None:
            self.right = node
        elif type(self.data) is type(node.data):
            self.right = node
        else:
            raise TypeError("Type mismatch between " + str(type(self.data))[8:-2] + " and " + str(type(node.data))[8:-2])

    def add_leftchild(self, node):
        if node is None:
            self.left = node
        elif self.data is None or node.data is None:
            self.left = node
        elif type(self.__data) is type(node.data):
            self.left = node
        else:
            raise TypeError("Type mismatch between " + str(type(self.data))[8:-2] + " and " + str(type(node.data))[8:-2])

    def preorder(self):
        if self.data is not None:
            yield self.data
        if self.left is not None:
            for d in self.left.preorder():
                yield d
        if self.right is not None:
            for d in self.right.preorder():
                yield d

    def __iter__(self):
        return self.preorder().__iter__()