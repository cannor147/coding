package channel

import affect.SymmetricAffection

class BinarySymmetricChannel(probability: Double) : BinaryChannel(SymmetricAffection(probability))
